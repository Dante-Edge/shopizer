
$(function(){
    initBidBindings();
});

function bid(productId) {
    $('#pageContainer').showLoading();    
    $.ajax({
        url: "../bid/",
        method: "POST",
        contentType: "application/json",
        data: productId + ''
    })
    .always(function(){
        $('#pageContainer').hideLoading();  
    });  
}

function initBidBindings() {
    $(".bidButton").click(function(){
        bid($(this).attr("productId"));
    });
}