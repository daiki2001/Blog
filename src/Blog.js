import React, { useState, useEffect } from 'react';
import './Blog.css';
import Comment from './Comment';

function Blog() {
    let [data, setData] = useState([]);

    useEffect(() => {
        console.log("call useEffect START");
        fetch('http://localhost:8080/blog').then(res => {
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