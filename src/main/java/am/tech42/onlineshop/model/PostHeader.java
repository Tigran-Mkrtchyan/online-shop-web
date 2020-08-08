package am.tech42.onlineshop.model;

public class PostHeader {

    private int id;
    private String imageUrl;
    private String header;
    private double price;

    public PostHeader(int id, String imageUrl, String header, double price) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.header = header;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

/*
create table posts
(
    id          serial primary key,
    user_id     int  not null,
    category_id int  not null,
    header      text not null,
    description text not null,
    published   bool default true,
    foreign key (user_id) references users (id),
    foreign key (category_id) references categories (id)
);
 */
