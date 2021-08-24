function Book(props){
    

    return(
        <article className="book-article" onClick={() => console.log(`${props.title} is clicked`)}>
            <h3>{ props.title }</h3>
            <p>{ props.description  || 'Default Description'}</p>
        </article>
    );
}

export default Book;