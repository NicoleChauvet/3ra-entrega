package dsi.ppai.init;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

public class DBInit {

    public static void main(String[] args) throws Exception {
        // Intentar localizar una carpeta ya existente 'src/main/resources/db' en algún
        // ancestro
        Path existing = findExistingResourcesDb();
        Path dbDir;
        if (existing != null) {
            dbDir = existing;
            System.out.println("Usando carpeta existente para la DB: " + dbDir.toAbsolutePath());
        } else {
            // Si no existe, crear la carpeta relativa (fallback)
            dbDir = Paths.get("red-sismica", "src", "main", "resources", "META-INF");
            Files.createDirectories(dbDir);
            System.out.println("Carpeta no encontrada arriba en el arbol; creada: " + dbDir.toAbsolutePath());
        }

        Path dbPath = dbDir.resolve("red-sismica.db");
        String jdbcUrl = "jdbc:sqlite:" + dbPath.toString();

        System.out.println("Inicializando base de datos SQLite en: " + dbPath.toString());

        try (Connection conn = DriverManager.getConnection(jdbcUrl)) {
            // habilitar foreign keys
            try (Statement s = conn.createStatement()) {
                s.execute("PRAGMA foreign_keys = ON;");
            }

            // cargar schema desde resources/sql/schema.sql
            try (InputStream is = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("META-INF/schema.sql")) {
                if (is == null) {
                    System.err.println("No se encontró resource sql/schema.sql en el classpath.");
                    System.exit(1);
                }

                try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                    String sql = br.lines().collect(Collectors.joining("\n"));

                    // dividir por ; para ejecutar statements individuales
                    String[] statements = sql.split(";");
                    for (String stmtSql : statements) {
                        String s = stmtSql.trim();
                        if (s.isEmpty())
                            continue;
                        try (Statement stmt = conn.createStatement()) {
                            stmt.execute(s);
                        }
                    }
                }
            }

            System.out.println("Esquema ejecutado correctamente. Archivo creado: " + dbPath.toString());

        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
            e.printStackTrace();
            System.exit(2);
        }
    }

    private static Path findExistingResourcesDb() {
        Path cwd = Paths.get("").toAbsolutePath();
        Path p = cwd;
        while (p != null) {
            Path candidate = p.resolve(Paths.get("src", "main", "resources", "db"));
            if (Files.exists(candidate) && Files.isDirectory(candidate)) {
                return candidate;
            }
            Path parent = p.getParent();
            if (parent == null || parent.equals(p))
                break;
            p = parent;
        }
        return null;
    }

}
