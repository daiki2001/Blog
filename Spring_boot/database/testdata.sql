-- blogテーブルにテストデータをセット
INSERT INTO blog (title, article) VALUES
("はじめまして", "ブログ開設しました!!よろしくお願いします!!"),
("解説記事", "○○はこうなっているから、××はこうなります。");

-- commentテーブルにテストデータをセット
INSERT INTO comment (blog_id, name, article)
VALUES
(1, "ななし", "楽しみ!!"),
(1, "nanasi", ""),
(2, "bugs", "バグだらけ");