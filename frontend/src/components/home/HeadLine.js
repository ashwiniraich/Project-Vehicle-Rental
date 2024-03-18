import React from 'react'

const HeadLine = (props) => {
    return (
        <div className="container" style={{marginBottom:50}}>
            <div className="row fs-2 d-flex justify-content-center">
                {props.text}
                <p className="fs-6 text-center">{props.subText}</p>
            </div>
           
        </div>
    )
}

export default HeadLine
