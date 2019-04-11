const privacyButton = document.getElementById('privacy-button');
const privacyDiv = document.getElementById('privacy-div');
const logoButton = document.getElementById('logo');
const homePageDiv = document.getElementById('home-page-div');

if (privacyButton) {
    privacyButton.addEventListener('click', () => {

        if (privacyDiv == null || homePageDiv == null) {
            console.log('Error! ID not found');
        } else {
            if (privacyDiv.style.display === 'none') {
                privacyDiv.style.display = 'block';
                homePageDiv.style.display = 'none';
            } else {
                homePageDiv.style.display = 'grid';
                privacyDiv.style.display = 'none';
            }
        }        

});}else{
    console.log('No button found'); 
}
