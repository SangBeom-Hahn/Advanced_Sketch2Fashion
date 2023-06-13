CREATE TABLE member
(
    member_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45),
    login_id VARCHAR(45),
    password VARCHAR(45),
    email VARCHAR(45) UNIQUE
);

CREATE INDEX idx_name_login_id ON member (name, login_id);
CREATE INDEX idx_login_id ON member (login_id);

CREATE TABLE choose_list (
    choose_id bigint AUTO_INCREMENT PRIMARY KEY,
    member_id bigint NOT NULL,
    CONSTRAINT fk_choose_list_member1
        FOREIGN KEY (member_id)
            REFERENCES member (member_id)
);




