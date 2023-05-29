package pl.kamski;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.kamski.ProductCatalog.Product;

import java.util.UUID;

@SpringBootTest
public class JdbcPlaygroundTest {

    @Autowired
    JdbcTemplate db;

    @BeforeEach
    void setup(){
        db.execute("DROP TABLE  `products` IF EXISTS");
        db.execute("CREATE TABLE `products`(" +
                "`id` VARCHAR(100)," +
                "`name` VARCHAR(100)," +
                "`desc` VARCHAR(100)," +
                "PRIMARY KEY(id)" +
                ")");
    }


    @Test
    void testIt(){
        String result = db.queryForObject("select 'Hello world'", String.class);

        assert result.equals("Hello world");
    }

    @Test
    void insert(){

    Product product = new Product(UUID.randomUUID(), "Lego", "Nice one!");
    db.update("INSERT INTO `products` (`id`,`name`,`desc`) values (?,?,?)",
            product.getId(),
            product.getName(),
            product.getDescription());

    int productsCount = db.queryForObject("select count(*) from products", Integer.class);
    assert productsCount == 1;
    }

    @Test
    void Select(){
        Product product = new Product(UUID.randomUUID(), "Lego", "Nice one!");
        db.update("INSERT INTO `products` (`id`,`name`,`desc`) values (?,?,?)",
                product.getId(),
                product.getName(),
                product.getDescription());

        String sql = "select * from products where id = ?";

        Product loaded = db.queryForObject(sql, new Object[]{product.getId()}, (rs, i) -> {
            return new Product(
                    UUID.fromString(rs.getString("id")),
                    rs.getString("name"),
                    rs.getString("desc")

            );
        });

        assert product.getId().equals(loaded.getId());
    }
}
