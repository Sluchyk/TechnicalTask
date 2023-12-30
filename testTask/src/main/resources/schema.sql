DROP TABLE IF EXISTS job_entity;
CREATE TABLE IF NOT EXISTS job_entity (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    job_page_url VARCHAR(255),
    position_name VARCHAR(255),
    url_to_organization VARCHAR(255),
    logo_url VARCHAR(255),
    organization_title VARCHAR(255),
    labor_function VARCHAR(255),
    address VARCHAR(255),
    posted_date BIGINT,
    description LONGTEXT,
    tag_name VARCHAR(255)
);
