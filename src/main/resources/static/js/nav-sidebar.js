$(document).ready(function () {

    const navItems = document.querySelectorAll('.list-group-item');

     // var currentUrl = window.location.pathname;

    // navItems.forEach(item => {
    //     item.addEventListener('click', () => {
    //         console.log(currentUrl)
    //         // Remove the "active" class from all the other navbar elements
    //         navItems.forEach(otherItem => {
    //             otherItem.classList.remove('active');
    //         });
    //
    //         // Add the "active" class to the clicked navbar element
    //         item.classList.add('active');
    //     });
    // });



    // Get the current URL
    var currentUrl = window.location.href;
    console.log(currentUrl);

    //Select all the sidebar links
    var sidebarLinks = document.querySelectorAll("#sidebarMenu a");

    // Loop through each link and check if the current URL starts with its href
    for (var i = 0; i < sidebarLinks.length; i++) {
        if (currentUrl.startsWith(sidebarLinks[i].href)) {
            sidebarLinks[i].classList.add("active");
        } else {
            sidebarLinks[i].classList.remove("active");
        }
    }




});
