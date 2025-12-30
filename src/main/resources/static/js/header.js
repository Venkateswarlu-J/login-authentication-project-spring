// 🔐 Simulated session check (replace with real backend logic)
const isLoggedIn = true; // false for login/register pages
function secAuth(isLoggedIn){
const navLinks = document.getElementById("navLinks");
const profileBox = document.getElementById("profileBox");
const profileMenu = document.getElementById("profileMenu");

// Show navbar only if logged in
if (isLoggedIn) {
    navLinks.style.display = "block";
    profileBox.style.display = "block";
}
}

fetch('/username')
    .then(res=>res.text())
        .then(msg=>{
            document.getElementById("user").innerText=msg;
});

function goHome() {
    if (isLoggedIn) {
        window.location.href = "/Main";
    } else {
        window.location.href = "/";
    }
}

//profile
function toggleProfile() {
    profileMenu.style.display =
        profileMenu.style.display === "block" ? "none" : "block";
}

// Close dropdown when clicking outside
window.onclick = function (e) {
    if (!e.target.closest(".profile")) {
        profileMenu.style.display = "none";
    }
};
