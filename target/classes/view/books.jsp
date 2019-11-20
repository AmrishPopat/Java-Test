<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Penguin Random House - Java Test</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/css/style.css">
    </head>
    <body>
	    <!-- example component start-->
	    <section class="component  bookshelfCarousel">
	        <div class="bookshelfCarousel__itemListContainer">
	            <ul class="bookshelfCarousel__itemList">
	                <li class="bookshelfCarousel__itemList__item">
	                    <div class="component__item boxWrapper bookCard">
	                    	<c:if test="${empty book}">
	                    		<h2>Book not found</h2>
	                    	</c:if>
							<c:if test="${not empty book}">	                    	
		                        <a class="bookCard__link" href="${book.url}" title="${book.title}">
		                            <div class="bookCard__wrapper">
		                                <div class="box__image box__image--withHover bookCard__imageContainer" >
		                                    <div class="bookCard__image">
		                                        <img src="/${book.image}" alt="${book.title}" >
		                                    </div>
		                                </div>
		                                <div class="bookCard__contentContainer">
		                                    <h5 class="bookCard__title">${book.title}</h5>
		                                    <h6 class="bookPromo__details__authorName">${book.author}</h6>
		                                </div>
		                            </div>
		                        </a>
	                        </c:if>
	                    </div>
	                </li>
	            </ul>
	        </div>
	    </section>
	    <!-- examplecomponent end-->
    </body>
</html>
