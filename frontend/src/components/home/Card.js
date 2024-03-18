import React from 'react'

const Card = (props) => {
    return (
        <div>
            <div class="card" style={{width:'12rem',height:"200px"}} >
                <img src={props.image} class="card-img-top" alt="" style={{ width: '80%', height: '60%' }} />
                <div class="card-body">
                    <h5 class="card-title">{props.text}</h5>
                    <p class="card-text">{props.text2}</p>
                </div>
            </div>

        </div>
    )
}


export default Card
