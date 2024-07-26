<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!-- 경력계산 민중 07/25 12:07 -->
		<%@ page import="java.util.Calendar" %>
			<%@ page import="java.util.Date" %>
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="UTF-8">
					<meta http-equiv="X-UA-Compatible" content="IE=edge">
					<meta name="viewport" content="width=device-width, initial-scale=1.0">
					<title>기업정보</title>
					<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
					<link rel="stylesheet"
						href="${pageContext.request.contextPath}/css/jobpostingIndividualSupport.css">
					<!-- import font-awesome, line-awesome -->
					<link rel="stylesheet"
						href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
					<link rel="stylesheet"
						href="https://cdnjs.cloudflare.com/ajax/libs/line-awesome/1.3.0/line-awesome/css/line-awesome.min.css">
					<!-- import pretendard font -->
					<link rel="stylesheet" as="style" crossorigin
						href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.8/dist/web/variable/pretendardvariable.css" />
					<!-- import js -->
					<script src="https://code.jquery.com/jquery-3.6.3.min.js"
						integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
						crossorigin="anonymous"></script>
					<!--   <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>-->

				</head>
				<style>
					:root {
						/* 컬러 모음 */
						--main-color: #FFA500;
						--color-black: #111;
						--color-white: #fff;
						--color-gray: #787878;
						--input-gray: #e5e5ec;
						--button-gray: #f7f7f7;
						--border-color-gray: #dadada;
						--font-size32: 32px;
						--font-size24: 24px;
						--font-size20: 20px;
						--font-size16: 16px;
						--font-size14: 14px;
						--font-size12: 12px;
					}




					/*    섹션    */

					section {
						display: flex;
						justify-content: center;

					}

					.wrap {
						min-width: 1200px;
						padding: 70px 0;
						box-sizing: border-box;
						display: flex;
					}

					.devlist {
						width: 1200px;
					}


					.selectbox {
						display: flex;
					}




					.selectbox .select .title {
						padding-left: 20px;
						margin: 0 0 30px 0;
						border: 1px solid var(--input-gray);
						border-radius: 10px;
						padding: 16px 20px;
						width: 1158px;
						display: flex;
					}

					.selectbox .icon {
						position: absolute;
					}

					.selectbox .icon {
						right: 380px;
						margin-top: 16px;
					}



					.filterbox {
						display: flex;
						margin-bottom: 64px;
					}


					.filterbox .right {
						width: initial;
						display: flex;
						margin-left: auto;
					}


					.filterbox .left {
						display: flex;
					}



					/* 버튼시작 */

					.right .fil2 {
						margin-left: 8px;
						border: 1px solid var(--input-gray);
						background-color: var(--color-white);
						border-radius: 10px;

						width: 80px;
						height: 40px;
						cursor: pointer;

						&:hover {
							background: var(--main-color);
							color: #fff;
						}
					}




					/* 버튼 끝 */


					/* .filterbox .fil
	{
	    margin: 0 14px 0 0;
	    border: 1px solid var(--input-gray);
	    border-radius: 10px;
	    padding: 14px 18px;
	    width: initial;
	    display: flex;
	    background-color: var(--color-white);
	} */


					.filterbox .fil .filter .last,
					.filterbox .fil2 .but1,
					.filterbox .fil3 .but1,
					.menutitle .company .c1,
					.menutitle .location .l1 {
						font-size: var(--font-size14);
						font-weight: 300;
					}

					.selectbox .title {
						font-size: var(--font-size16);
						font-weight: 300;
						width: 1100px;
						border: none;
						resize: none;

					}

					.sbox .select1 {
						height: 40px;
						border-radius: 10px;
						border: solid 1px var(--input-gray);
						padding: 0 15px;
						font-size: var(--font-size14);
						font-weight: 200;
						margin-right: 14px;
					}





					.menutitle .company {
						margin-bottom: 4px;
					}

					.mtlist {
						display: grid;
						grid-template-columns: 270px 270px 270px 270px;
						gap: 40px;
					}

					.menutitle {
						max-width: 270px;

					}

					/* .latest 추가 */
					.menutitle .title .t1 {
						font-size: var(--font-size16);
						font-weight: 600;
					}

					.menubox {
						display: flex;
						margin-bottom: 16px;
						position: relative;
					}

					.menubox .img {
						width: 270px;
						height: 180px;
						background-image: url(../images/company.svg);
						background-position: center;
						background-size: cover;
						border-radius: 10px;

					}

					.menubox .scrap {
						position: absolute;
						top: 15px;
						right: 12px
					}

					.menubox .a:hover {
						border: 1px solid var(--main-color);
						background-color: var(--main-color);
						color: var(--main-color);
					}






					.titlebox {
						width: 270px;
						height: 90px;
					}

					.titlebox .title {
						margin-bottom: 8px;
					}



					.mtlist {
						margin-bottom: 60px;
					}

					.pagingbox {
						margin-bottom: 60px;
					}
				</style>

				<body>
					<%@ include file="header.jsp" %>

						<!-- 섹션-->


						<!-- 섹션-->
						<section>
							<div class="wrap">
								<div class="devlist">

									<div class="selectbox">
										<div class="select">
											<input class="title" type="text" placeholder="검색어를 입력해 주세요">
										</div> <!-- 콘텐트박스 끝-->
										<div class="icon">
											<div class="i1">
												<a href="#" class="fa-solid fa-magnifying-glass"
													style="color: #ffa500;"></a>
											</div>
										</div>
									</div> <!-- selectbox 끝-->




									<div class="filterbox">
										<div class="left">
											<div class="sbox">
												<form>
													<select class="select1" id="select" name="select">
														<option value="">직군 · 직무</option>
														<c:forEach var="job" items="${jobList}">
															<option value="s1">${job}</option>
														</c:forEach>
													</select>
												</form>
											</div> <!-- selectbox 끝 -->
											<!-- <div class="sbox">
	                                <form>
	                                    <select class="select1" id="select" name="select">
	                                      <option value="">경력</option>
	                                        <option value="s1">공지사항</option>
	                                        <option value="s1">이벤트</option>
	                                    </select>
	                                  </form>
	                            </div> selectbox 끝 -->
											<div class="sbox">
												<form>
													<select class="select1" id="select" name="select">
														<option value="">기술스택</option>
														<c:forEach var="stack" items="${stackList}">
															<option value="${stack}" <c:if
																test="${pageMaker.cri.type eq stack}">selected</c:if>
																>${stack}</option>
														</c:forEach>
													</select>
												</form>
											</div> <!-- selectbox 끝 -->
											<div class="sbox">
												<form>
													<select class="select1" id="select" name="select">
														<option value="">지역</option>
														<!-- <c:forEach var="location" items="${location}">
													<option value="">${location_name}</option>
												</c:forEach> -->
														<c:forEach var="location" items="${locationList}">
															<option value="s1">${location}</option>
														</c:forEach>
													</select>
												</form>
											</div> <!-- selectbox 끝 으아아아ㅏ아아ㅏ-->


										</div> <!-- 레프트 끝-->

										<!-- <div class="right">
											<button class="fil2">
												<div class="tableCon recommendation">
													<h5 class="but1">
														추천순
													</h5>
												</div>
											</button>
											<button class="tab-btn active">
												<div class="tableCon latest">
													<h5 class="but1">
														최신순
													</h5>
												</div>
											</button>
											<button class="fil2">
												<div class="tableCon hit">
													<h5 class="but1">
														조회순
													</h5>
												</div>
											</button>
										</div> 라이트 끝 -->

										<div class="right" id="tabs">
											<button class="fil2" onclick="switchTab('latest', event)">최신순</button>
											<button class="fil2"
												onclick="switchTab('recommendation', event)">추천순</button>
											<button class="fil2" onclick="switchTab('hit', event)">조회순</button>
										</div>
										<!-- <div class="right" id="tabs">
											<button class="tab-btn active" onclick="switchTab('latest', event)">최신순</button>
											<button class="tab-btn" onclick="switchTab('recommendation', event)">추천순</button>
											<button class="tab-btn" onclick="switchTab('hit', event)">조회순</button>
										</div> -->
									</div> <!-- filterbox 끝 -->

									<!-- <div class="tableWrap">
								<div class="tableConWrap">

									<div class="tabConDiv">
										<div class="tableCon recommendation">추천순</div>
										<div class="tableCon latest">최신순</div>
										<div class="tableCon hit">조회순</div>
									</div>
									
								</div>
							</div> -->

									<!-- <div id="latest" class="form-box active">  latest 시작 -->
									${comList}
									<div class="mtlist"> <!--  mtlist 시작-->
										<c:forEach var="dto" items="${comList}">
											<div class="menutitle">
												<div class="menubox">
													<a href="/comDetail?com_email=${dto.com_email}" class="tag">
														<div class="img"></div>
													</a>
													<div class="scrap">
														<div class="s1">
															<a href="#" class="fa-solid fa-bookmark"
																style="font-size: 20px; color: #e5e5ec;"></a>
														</div>
													</div>
												</div>

												<div class="titlebox">
													<a href="/comDetail?com_email=${dto.com_email}">
														<div class="title">
															<h5 class="t1">
																${dto.com_name}
															</h5>
														</div>
													</a>
													<!-- <a href="연동 기업상세/index.html"> -->
													<div class="company">
														<h5 class="c1">
															★ ${dto.com_star}
														</h5>
													</div>
													<div class="location">
														<h5 class="l1">
															${dto.com_location} • ${dto.experienceYears}년차
															(${dto.com_year})
														</h5>
													</div>
													<!-- <div class="experience">
												<h5 class="y1">
												</h5>
											</div> -->
													</a>
												</div>
											</div>
										</c:forEach>
									</div> <!-- milist 끝-->
									<!-- </div> latest 끝 -->
									<div class="pagingbox">
										<!-- <h3>${paging}</h3> -->
										<div class="paging">
											<ul>
												<c:if test="${paging.prev}">
													<!-- <li>[Previous]</li> -->
													<li class="paginate_button">
														<a href="${paging.startpage - 1}">
															[Previous]
														</a>
													</li>
												</c:if>

												<c:forEach var="num" begin="${paging.startpage}"
													end="${paging.endpage}">
													<li class="paginate_button" ${paging.std.pageNum==num
														? "style='background-color: yellow'" : "" }>
														<!-- [${num}] -->
														<a href="${num}">
															[${num}]
														</a>
													</li>
												</c:forEach>

												<c:if test="${paging.next}">
													<!-- <li>[Next]</li> -->
													<li class="paginate_button">
														<a href="${paging.endpage + 1}">
															[Next]
														</a>
													</li>
												</c:if>
											</ul>
										</div><!--paging-->
									</div><!--pagingbox-->

								</div> <!-- devlist 끝 -->
							</div> <!-- wrap 끝 -->
						</section> <!--section 끝 -->

						<%@ include file="footer.jsp" %>
							<form id="" method="get" action="companyPageList">
								<input type="hidden" name="pageNum" value="${paging.std.pageNum}">
								<input type="hidden" name="amount" value="${paging.std.amount}">
							</form>
				</body>

				</html>
				<script>

					$(document).ready(function () {

						const resumeStack = "${jobpostingIndividualSupport}";
						console.log("@####" + resumeStack);
						return false;
						const stacks = resumeStack.split(','); // 콤마로 나눠서 배열로 저장
						console.log(stacks);
						let output = "";
						for (let i = 0; i < stacks.length; i++) {
							output += "<div class=mm1>" + stacks[i].trim() + "</div>";
						}
						console.log("@# output=>" + output);
						$('#stack').html(output);
					});




					var actionForm = $("#actionForm");

					//페이지 번호 처리
					// $(".paginate_button").on("click", function (e){
					$(".paginate_button a").on("click", function (e) {
						//기본 동작 막음: 페이지 링크를 통해서 이동
						e.preventDefault();
						console.log("click~!!!");
						console.log("@# href=>" + $(this).attr("href"));

						// 게시글 클릭후 뒤로가기 누른 후 다른 게시글 클릭할 때 &boardNo=번호 계속 누적되는거 방지
						var bno = actionForm.find("input[name='boardNo']").val();
						if (bno != "") {
							actionForm.find("input[name='boardNo']").remove();
						}

						actionForm.find("input[name='pageNum']").val($(this).attr("href"));
						// actionForm.submit();
						actionForm.attr("action", "comList").submit();
					});//end of paginate_button click


					// type 콤보박스 변경
					$("#searchForm select").on("change", function () {
						// 전체일때
						if (searchForm.find("option:selected").val() == "") {
							// 키워드를 null값으로 변경함
							searchForm.find("input[name = 'keyword']").val("");
						}
					}); // searchForm select change 끝

					function switchTab(tab, event) {
						document.querySelectorAll('.form-box').forEach(function (el) {
							el.classList.remove('active');
						});
						document.querySelectorAll('.tab-btn').forEach(function (el) {
							el.classList.remove('active');
						});
						document.getElementById(tab).classList.add('active');
						event.currentTarget.classList.add('active');
						clearForm(); // 폼 필드 초기화
					}
				</script>