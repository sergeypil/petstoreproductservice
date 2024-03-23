create table if not exists category (
    id int8 not null,
    name varchar(255),
    primary key (id)
);

create table if not exists product (
    id int8 not null,
    name varchar(255),
    photourl varchar(255),
    status varchar(255),
    category_id int8,
    primary key (id),
    foreign key (category_id) references category (id)
);

create table if not exists tag (
    id int8 not null,
    name varchar(255),
    primary key (id)
);

create table if not exists producttag (
    product_id int8 not null,
    tag_id int8 not null,
    foreign key (product_id) references product (id),
    foreign key (tag_id) references tag (id)
);