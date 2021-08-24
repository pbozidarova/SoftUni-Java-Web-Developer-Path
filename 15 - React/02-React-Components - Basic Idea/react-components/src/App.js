import './App.css';
import Heading from './components/Heading';

import BookList from './components/BookList';
import Counter from './components/Counter';

function App() {

	const booksData = [
		{title: 'Harry Potter', description: 'Wizzards and stuff'},
		{title: 'Effective Java', description: 'Read it already'},
		{title: 'Hopla Tropla', description: 'Kids Book'},
	] 

  return (
		<div className='site-wrapper'>
			<Heading>
				Our Custom Library
			</Heading>

			<Counter />

			<BookList books={booksData}/>
		</div>
  );
}

export default App;
