
import {Component} from 'react';
import Book from "./Book";

class BookList extends Component {
    
    constructor(props){
        super(props);
    }

    render(){
        console.log(this.props);

        return(
                <div className='book-list'>
                    <h2>Our Book collection</h2>
                    {this.props.books.map(book =>{
                        return<Book title={book.title} description={book.description} />
                    })}    
                    {/* <Book title={} description="Wizzards and stuff"/>
                    <Book title="Effective Java" description="Read it already"/>
                    <Book title="Hopla Tropla" description="Kids' Book"/> */}

                </div>
        )
    }
    
}

export default BookList;

