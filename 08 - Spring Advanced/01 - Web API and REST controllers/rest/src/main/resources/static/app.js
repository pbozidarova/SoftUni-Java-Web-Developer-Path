$('#loadAuthors').click(() => {

    $('.authors-container').empty();
    $('.books-container').empty();

    fetch('http://localhost:8080/authors') // Fetch the data (GET request)
        .then((response) => response.json()) // Extract the JSON from the Response
        .then((json) => json.forEach((author, idx) => { // Render the JSON data to the HTML

            let tableRow =
                '<tr>' +
                '<td>' + author.id + '</td>' +
                '<td>' + author.name + '</td>' +
                '<td>' +
                '<button class="book-btn" data-author-id="' + author.id + '">Show books</button>' +
                '</td>' +
                '<td>' +
                '<button class="delete-btn" data-author-id="'+ author.id +  '">Delete</button>' +
                '</td>' +
                '</tr>';

            $('.authors-container').append(tableRow);
        }));
});

$('body').on('click', 'button.book-btn', function() {
    let authorId = $(this).data('author-id');
    console.log("Author ID is " + authorId)

    $('.books-container').empty();

    fetch('http://localhost:8080/authors/'+authorId+'/books') // Fetch the data (GET request)
        .then((response) => response.json()) // Extract the JSON from the Response
        .then((json) => json.forEach((book, idx) => { // Render the JSON data to the HTML
            console.log(book.title);

            let tableRow =
                '<tr>' +
                '<td>' + book.title + '</td>' +
                '<td>' +
                '<button>Delete</button>' +
                '</td>' +
                '</tr>';

            $('.books-container').append(tableRow);
        }));

});

$('body').on('click', 'button.delete-btn', function() {
    let authorId = $(this).data('author-id');
    console.log("Author ID to delete is " + authorId)

    fetch('http://localhost:8080/authors/'+authorId, {
        method: 'delete'
    })
        .then(data => {
            console.log("Author deleted!")
            $('.authors-container').empty();
            $('.books-container').empty();
            $('#loadAuthors').click();
        })
        .catch((error) => {
            console.error('Error:', error);
            location.reload();
        });

});