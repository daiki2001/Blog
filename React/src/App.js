import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

// ページの共通部分
import Header from './Common/Header';
import Footer from './Common/Footer';
import './App.css';

// 各ページのページコンポーネント
import Home from './Home';
import Articles from './Articles/Articles';
import Article from './Articles/Article';
import Notfound from './Notfound';

function App() {
    return (
        <Router>
            <div className="App">
                <Header />
                {/* 各ページへのルート設定 */}
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/Blog" element={<Articles />} />
                    <Route path="/Blog/:id" element={<Article />} />
                    <Route path="*" element={<Notfound />} />
                </Routes>
                {/* <Blog blog={1} /> */}
                <Footer />
            </div>
        </Router>
    );
}

export default App;
