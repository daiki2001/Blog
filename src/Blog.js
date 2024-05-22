import React, { useState, useEffect } from 'react';
import './Blog.css';
import Comment from './Comment';

function Blog(blog) {
    let [data, setData] = useState(blog);
    console.log(data);

    useEffect(() => {
        console.log("call useEffect START");
        const path = 'http://localhost:8080/blog'
        console.log("PATH: " + path);
        fetch(path).then(res => {
            res.json().then(value => {
                console.log(value);
                setData(value);
            })
        }).catch(error => {
            console.log(error);
            setData([]);
        });

        console.log("call useEffect END");
        return () => { };
    }, []);

    return (
        <div id='Blog'>
            {data.map((item, index) => (
                <div key={index} id='Blog_line'>
                    <h2>{item.title}</h2>
                    <p>{item.article}</p>
                    <Comment blog={item} />
                </div>
            ))}
        </div>
    );
}

export default Blog