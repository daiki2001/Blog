-- commentテーブルを削除する
DROP TABLE IF EXISTS comment;

-- commentテーブルを作成する（上書き保存する）
CREATE TABLE comment (
	id          INT	NOT NULL AUTO_INCREMENT,            -- 管理番号
	blog_id		INT	NOT NULL,							-- 記事の管理番号
	name	    TEXT NOT NULL,							-- 返信者名
	article	    TEXT NOT NULL,							-- コメント
	posttime	TIMESTAMP	DEFAULT CURRENT_TIMESTAMP,  -- 投稿日時
	updatetime	TIMESTAMP	DEFAULT CURRENT_TIMESTAMP,  -- 更新日時
	PRIMARY KEY(id),
	FOREIGN KEY(blog_id) REFERENCES blog(blog_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

-- commentテーブルにテストデータをセット
INSERT INTO comment (blog_id, name, article)
VALUES
(1, "ななし", "楽しみ!!"),
(1, "nanasi", "");