-- blogテーブルを削除する
DROP TABLE IF EXISTS blog;

-- blogテーブルを作成する（上書き保存する）
CREATE TABLE blog (
	blog_id     INT	NOT NULL AUTO_INCREMENT,            -- 管理番号
	title	    TEXT NOT NULL,                          -- 記事タイトル
	article	    TEXT NOT NULL,                          -- 記事本文
	posttime	TIMESTAMP	DEFAULT CURRENT_TIMESTAMP,  -- 投稿日時
	updatetime	TIMESTAMP	DEFAULT CURRENT_TIMESTAMP,  -- 更新日時
	PRIMARY KEY(blog_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

-- blogテーブルにテストデータをセット
INSERT INTO blog (title, article)
VALUES
("はじめまして", "ブログ開設しました!!よろしくお願いします!!"),
("解説記事", "○○はこうなっているから、××はこうなります。");