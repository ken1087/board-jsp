<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시글 상세</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">  <!-- Font Awesome 아이콘 -->
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f7fa;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 70%;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        .board-title {
            font-size: 2rem;
            font-weight: bold;
            color: #2c3e50;
            margin-bottom: 10px;
        }

        .board-meta {
            font-size: 1rem;
            color: #7f8c8d;
            margin-bottom: 20px;
        }

        .board-content {
            font-size: 1.2rem;
            line-height: 1.6;
            color: #34495e;
            margin-bottom: 30px;
        }

        .actions {
            text-align: center;
            margin-top: 30px;
        }

        .btn {
            background-color: #3498db;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            font-size: 1rem;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #2980b9;
        }

        .btn-danger {
            background-color: #e74c3c;
        }

        .btn-danger:hover {
            background-color: #c0392b;
        }

        .error-message {
            color: #e74c3c;
            font-size: 1.2rem;
            text-align: center;
            margin-top: 20px;
        }

        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            font-size: 1rem;
            color: #3498db;
            text-decoration: none;
        }

        .back-link:hover {
            color: #2980b9;
        }

    </style>
</head>
<body>
    <div class="container">
        <h1>게시글 상세</h1>

        <!-- 게시글 내용 출력 -->
        <c:if test="${not empty board}">
            <div class="board-title">${board.title}</div>
            <div class="board-meta">
                <span>작성일: ${board.createDate}</span> | 
                <span>수정일: ${board.updateDate}</span>
            </div>
            <div class="board-content">
                ${board.content}
            </div>

            <!-- 수정 및 삭제 버튼 -->
            <div class="actions">
                <a href="/boards/modify/${board.id}" class="btn">수정</a>
                <form action="/boards/delete/${board.id}" method="POST" style="display:inline;">
                    <input type="hidden" name="_method" value="DELETE">
                    <button type="submit" class="btn btn-danger">삭제</button>
                </form>
            </div>

            <!-- 목록으로 돌아가기 버튼 -->
            <a href="/boards" class="back-link">목록으로 돌아가기</a>
        </c:if>
    </div>
</body>
</html>