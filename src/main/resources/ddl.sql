drop table if exists users;
drop table if exists posts;
drop table if exists images;
drop table if exists featured_posts;
drop table if exists categories;

create table users
(
    id           serial primary key,
    name         text            not null,
    phone_number char(12) unique not null,
    password     text            not null,
    check ( char_length(phone_number) = 12 AND phone_number like '+374%')
);

create table categories
(
    id        serial primary key,
    name      text not null,
    parent_id int,
    foreign key (parent_id) references categories (id)
);

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

create table images
(
    id      serial primary key,
    post_id int  not null,
    path    text not null,
    foreign key (post_id) references posts (id)
);

create table featured_posts
(
    id         serial primary key,
    post_id    int  not null,
    start_date date not null,
    end_date   date not null,
    foreign key (post_id) references posts (id)
);
