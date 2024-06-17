-- データベースの作成
DROP DATABASE IF EXISTS site;
CREATE DATABASE site;
USE site;

-- blogテーブルを作成する（上書き保存する）
CREATE TABLE blog (
	blog_id     INT	NOT NULL AUTO_INCREMENT,            -- 管理番号
	title	    TEXT NOT NULL,                          -- 記事タイトル
	article	    TEXT NOT NULL,                          -- 記事本文
	posttime	TIMESTAMP	DEFAULT CURRENT_TIMESTAMP,  -- 投稿日時
	updatetime	TIMESTAMP	DEFAULT CURRENT_TIMESTAMP,  -- 更新日時
	PRIMARY KEY(blog_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

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
