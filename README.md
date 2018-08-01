# whisker  
ツイッター風掲示板の作成  

  
## 画面詳細とイメージ  

#### ・ログイン画面  
入力したIDをsession管理。空白か、データベースに入力した値がない場合にはエラー文を表示。  
![login](https://user-images.githubusercontent.com/39142831/43537761-2b120cae-95fb-11e8-8304-8a4d9bdc8134.png)  
（右：起動時画面 / 左：エラー表示）


#### ・新規ユーザー登録  
入力した情報をデータベースに登録。登録完了後はそのままホーム画面へ遷移させる。  
空白の場合や、文字を判定し規定外の文字もしくは規定数を超えた入力の場合にはエラー文を表示。  
![createuser](https://user-images.githubusercontent.com/39142831/43537846-63b77c88-95fb-11e8-88db-b4f70449a2f9.png)  
（左：入力欄 エラー表示 / 左：入力情報確認画面）


#### ・ホーム画面（デフォルト）  
初期状態では、プロフィール画像は登録がなければデフォルトを表示。  
左側にアカウント情報、右側に投稿記入欄と投稿表示欄を設置。
![homeinitial](https://user-images.githubusercontent.com/39142831/43537996-c89ac9d4-95fb-11e8-9e72-d40acfc63cc8.png)  


#### ・プロフィール編集画面  
画像の登録、表示名・紹介文の追記編集。  
![profileedit](https://user-images.githubusercontent.com/39142831/43538035-e60239bc-95fb-11e8-94d8-b7257a99fb1e.png)  


#### ・アカウント検索画面  
検索欄無記入の場合は、登録アカウントを全件表示。データベースから取得した自分以外の登録情報を取得。  
アカウント名をクリックして各アカウントページへ遷移。投稿欄には、表示した相手の投稿のみ表示される。  
選択中のアカウント欄は枠線で強調。  
![searchuser](https://user-images.githubusercontent.com/39142831/43538222-5df0964e-95fc-11e8-8af4-2105d89edb25.png)  
![homeother](https://user-images.githubusercontent.com/39142831/43538015-d85f37ba-95fb-11e8-8839-28ec9d358e49.png)  
（上：アカウント全件検索結果 / 下：選択したアカウントページ　プロフィール欄下部でフォロー/フォロー解除を行う。）


#### ・フォローリスト  
ログインしたアカウントでフォローをした相手の画像とアカウント名、ログイン解除ボタンを表示。  
選択中のアカウント欄は枠線で強調。  
![followlist](https://user-images.githubusercontent.com/39142831/43537944-a1119956-95fb-11e8-8663-1c5906c5077b.png)  


#### ・ホーム画面（機能使用後）  
投稿欄には、自分の投稿とフォローしたアカウントの投稿が新しいものから順に表示される。  
選択したアカウントはCSSで軽いエフェクトをつけて強調。肉球ボタン（一般的ないいねボタン）をを押すとカウントが+1され、別のアカウントでも同じカウント数で表示される。  
![homecomplete](https://user-images.githubusercontent.com/39142831/43537970-b2e3d3e2-95fb-11e8-95b1-5d4105dea647.png)  


