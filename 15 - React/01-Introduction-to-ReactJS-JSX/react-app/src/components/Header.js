

function Header(){
    let headingMessage = 'Hello React World!';

    return (
        <header className="App-header">
	    	<h1>{ headingMessage + '...'}</h1>
		    <h2>Hello on this line too</h2>
    	</header>
    
    )
}

export default Header;