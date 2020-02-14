$(document).ready(function() {
    $('a').on('click', function(e) {
        e.preventDefault();
        var pageRef = $(this).attr('href');
        console.log(pageRef)
        $.ajax({
            url: pageRef,
            type: "POST",
            dataType: 'text',
            success: function ( response ) {
                console.log('the page was loaded', response);
                $('.displayedInfo').html(response);
            },
            error: function ( error ) {
                console.log('something went wrong', error);
            }
        })
    })
})