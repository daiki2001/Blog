import './App.css';
import AllBlog from './AllBlog';
import Blog from './Blog';

function App() {
    return (
        <div className="App">
            {/* <AllBlog /> */}
            <Blog blog={1} />
        </div>
    );
}

export default App;
