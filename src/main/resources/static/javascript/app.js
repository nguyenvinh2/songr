function getItem() {
  var options = document.getElementById("album-list");
  var albumForms = document.getElementsByClassName("album-forms");
  for (let i = 0; i < albumForms.length; i++) {
    albumForms[i].style.display = "none";
    if (albumForms[i].id.value === options.value) {
      albumForms[i].style.display = "block";
    }
  }
}