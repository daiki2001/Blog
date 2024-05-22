import React, { useState, useEffect } from 'react';
import './Comment.css'

function Comment(blog) {
    let [data, setData] = useState([]);

    useEffect(() => {
        console.log("call useEffect START");
        const path = 'http://localhost:8080/blog/comment/' + blog.blog.id;
        console.log(blog);
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
        <div id='Comment'>
            {data.map((item, index) => (
                <div key={index} id='Comment_line'>
                    <p>{item.name}:{item.article}</p>
                </div>
            ))}
        </div>
    );
}

export default Comment