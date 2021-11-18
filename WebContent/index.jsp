<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Ajaxテスト用のjsp画面 --%>
<%-- テキストボックスに文字列を入力し、チェックというボタンをクリックすると非同期通信で絞り込み検索をしてくれる --%>
<%-- 該当する文字列があればダイアログボックスに文字列群を表示、なければ該当なしと表示される --%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
	</head>

	<body>
		<script>
			$(function() {

				// ボタン押下時の処理
				$('#ajax-btn').on('click', function(){
					$.ajax({
						url: "AjaxServlet",					// リクエストを送信する先のURL(今回はURLパターン)
						type: "GET",						// HTTPリクエストメソッド
						async: true,						// 非同期通信フラグの指定(初期値はtrue,falseは同期通信)
						data: {checkWord: $('#word').val()}		// サーバに送信する値。リクエストパラメータ名をcheckWordとする
					}).done(function (result) {
						// 通信成功時のコールバック
						alert(result);
					}).fail(function() {
						// 通信失敗時のコールバック
						alert("読み込み失敗");
					}).always(function (result) {
						// 常に実行する処理
					});
				});

			});
		</script>

		<form action="">
			<input type="text" name="word" id="word"> <button type="button" id="ajax-btn">チェック</button>
			<button type="submit" id="touroku-btn">登録</button>
		</form>
	</body>

</html>