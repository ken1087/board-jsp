<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Board List</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        th, td {
            padding: 8px 12px;
            border: 1px solid #ccc;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        .btn-write {
            display: inline-block;
            padding: 10px 20px;
            margin: 20px auto;
            text-align: center;
            background-color: #4CAF50;
            color: white;
            font-size: 16px;
            text-decoration: none;
            border-radius: 5px;
        }
        .btn-write:hover {
            background-color: #45a049;
        }

        .btn-detail {
            display: inline-block;
            padding: 10px 20px;
            margin: 20px auto;
            text-align: center;
            background-color: #1E90FF;
            color: white;
            font-size: 16px;
            text-decoration: none;
            border-radius: 5px;
        }
        .btn-detail:hover {
            background-color: #00BFFF;
        }

        .btn-delete {
            display: inline-block;
            padding: 10px 20px;
            margin: 20px auto;
            text-align: center;
            background-color: red;
            color: white;
            font-size: 16px;
            text-decoration: none;
            border-radius: 5px;
            border: 0;
        }
        .btn-delete:hover {
            background-color: #DC143C;
        }
    </style>
</head>
<body>
    <h1 style="text-align:center;">Board List</h1>
    <div style="width: 80%; margin: 0 auto;">
        <!-- 글쓰기 버튼 -->
        <div style="text-align: right;">
            <a href="/boards/write" class="btn-write">글쓰기</a>
        </div>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Created Date</th>
                    <th>Updated Date</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <!-- JSTL을 사용하여 boards 리스트 출력 -->
                <c:forEach var="board" items="${boards}">
                    <tr>
                        <td>${board.id}</td>
                        <td>${board.title}</td>
                        <td>${board.createDate}</td>
                        <td>${board.updateDate}</td>
                        <td>
                            <a href="/boards/get/${board.id}" class="btn-detail">상세</a>
                            <form action="/boards/delete/${board.id}" method="POST" style="display: inline;">
                                <button type="submit" class="btn-delete">삭제</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>