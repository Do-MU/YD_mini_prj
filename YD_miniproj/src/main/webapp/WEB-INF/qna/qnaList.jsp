<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
        .title{
            font-size: 3rem;
            font-weight: bold;
        }
        .conn{
            width: 15%;
            font-size: 1.2rem;
            font-weight: bold;
        }
        .cont{
            width: 55%;
            font-size: 1.2rem;
            font-weight: bold;
        }.conw{
            width: 10%;
            font-size: 1.2rem;
            font-weight: bold;
        }.cond{
            width: 150px;
            font-size: 1.2rem;
            font-weight: bold;
        }.cons{
            width: 100px;
            font-size: 1.2rem;
            font-weight: bold;
        }
        .pagelist{
            text-align: center;
        }
        .pagelist li{
            display: inline-block;
            list-style: none;
            padding: 10px;
        }
        .btn{
        	width: 150px;
        	display: block;
        	margin: auto;
        }
    </style>
    <title>도박장</title>
</head> 
<div class="title">고객센터</div>
<hr width = "100%" color = "gray">
<table align = "center" text-algin="left">
    <tr>
        <td class="conn">번호</td>
        <td class="cont">제목</td>
        <td class="conw">작성자</td>
        <td class="cond">작성일자</td>
        <td class="cons">상태</td>
    </tr>
</table>
    <div id="page_list" id="p_only">
        <ul class="pagelist">
            <li class="first_page">
                <a href=""><<</a>    
            </li>
            <li class="prev_page">
                <a href=""><</a>
            </li>
            <li>
                <a href="">1</a>
            </li>
            <li>
                <a href="">2</a>
            </li>
            <li>
                <a href="">3</a>
            </li>
            <li>
                <a href="">4</a>
            </li>
            <li>
                <a href="">5</a>
            </li>
            <li class="next_page">
                <a href="">></a>
            </li>
            <li class="last_page">
                <a href="">>></a>
            </li>
        </ul>
 		<div class="btn">
      		<button type="submit" id="btnsubmit">문의하기</button>
 		</div>
    </div>