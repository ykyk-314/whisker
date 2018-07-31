set names utf8;
set foreign_key_checks=0;

drop database if exists whisker;
create database if not exists whisker;

use whisker;

-- ユーザー
create table users(
	id int primary key not null auto_increment comment "ID",
	login_id varchar(16) unique not null comment "ログインID",
	password varchar(16) not null comment "パスワード",
	name varchar(100) not null comment "表示名",
	introductions varchar(500) not null default "紹介文" comment "紹介文",
	logined tinyint not null default 0 comment "ログインフラグ",
	created_at datetime not null comment "作成日",
	updated_at datetime not null comment "更新日"
);

insert into users(login_id, password, name, introductions, created_at, updated_at) values
("guest", "guest", "ゲスト", "紹介文", now(), now()),
("negishi", "ayaka", "NegishiAyaka", "プログラム大好き女子！空いている時間は全部プログラムの勉強してます！デザインにも興味津々！", now(), now()),
("endo", "takahiro", "EndoTakahiro", "ゲームプログラマー、使用可能言語・C＃、C言語、Java、JavaScript、PHP、C++、VBA、BASIC、HTML、CSS", now(), now()),
("nakayama", "eri", "NakayamaEri", "デザイン担当女子！いつもニコニコしてて、何を言っても笑っちゃいます！ツボが浅いことが取り柄！", now(), now()),
("yokoyama", "takahiro", "YokoyamaTakahiro", "最近ブラックな一面が出てしまうことが悩み・・・", now(), now()),
("kubota", "kyosuke", "KubotaKyosuke", "自分は、お父さん的な存在です！チーム制作でもリーダーに抜擢されました！", now(), now());



-- ツイート
create table tweets(
	id int primary key not null auto_increment comment "ID",
	user_id int not null comment "ユーザーID",
	content varchar(255) not null comment "内容",
	like_count int not null default 0 comment "いいねの数",
	created_at datetime not null comment "作成日",
	updated_at datetime not null comment "更新日",
	foreign key(user_id) references users(id)
);

insert into tweets(user_id, content, created_at, updated_at) values
(1, "初めまして！", now(), now()),
(1, "Gap_Timeアカウント作成しました！", now(), now()),
(1, "フォローしてください！", now(), now()),
(2, "オブジェクト指向に明確な説明はない・・・", now(), now()),
(2, "MySQLとは、世界でもっとも利用されている「データベース管理システム」です。", now(), now()),
(2, "SQLインジェクションとは、アプリケーションのセキュリティ上の不備を意図的に利用し、アプリケーションが想定しないSQL文を実行させることにより、データベースシステムを不正に操作する攻撃方法のこと。", now(), now()),
(3, "ラーメン食べたい", now(), now()),
(3, "ラーメンの味で一番好きなのは「醤油」", now(), now()),
(3, "カップ麺が一押し", now(), now()),
(4, "ダンス仲間募集してます！", now(), now()),
(4, "たまに、すごい寝相になっちゃいます・・・", now(), now()),
(4, "今日誰か映画見に行こー！", now(), now()),
(5, "純粋な心に戻りたい・・・", now(), now()),
(5, "少年のような心に戻りたい・・", now(), now()),
(5, "ホワイトの心を取り戻したい・・・", now(), now()),
(6, "チーム内で最年長・・・。就活不安・・", now(), now()),
(6, "家の中では、綾波レイになりきってます。", now(), now()),
(6, "焼肉食べたい", now(), now());

-- フォロー
create table follows(
	id int primary key not null auto_increment comment "ID",
	user_id int not null comment "ユーザーID",
	target_user_id int not null comment "フォローするユーザーID",
	created_at datetime not null comment "作成日",
	updated_at datetime not null comment "更新日",
	foreign key(user_id) references users(id),
	foreign key(target_user_id) references users(id)
);

insert into follows(user_id, target_user_id, created_at, updated_at) values
(1, 2, now(), now()),
(1, 5, now(), now()),
(1, 6, now(), now()),
(2, 1, now(), now()),
(2, 5, now(), now()),
(2, 6, now(), now()),
(3, 1, now(), now()),
(3, 2, now(), now()),
(3, 4, now(), now()),
(3, 5, now(), now()),
(3, 6, now(), now()),
(4, 1, now(), now()),
(4, 2, now(), now()),
(4, 3, now(), now()),
(4, 5, now(), now()),
(4, 6, now(), now()),
(5, 3, now(), now()),
(5, 1, now(), now()),
(5, 6, now(), now()),
(6, 3, now(), now()),
(6, 1, now(), now()),
(6, 4, now(), now()),
(1, 4, now(), now());