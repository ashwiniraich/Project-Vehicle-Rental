import React from 'react'
import bmw from '../../images/bmw.jpg'
import audi from '../../images/audi.jpg'
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css'
import HeadLine from './HeadLine'


const PopularCars = () => {
    return (
        <div className="container" style={{marginBottom:50}}>
            <HeadLine text="Popular Cars"/>
            <div className="d-flex justify-content-between">
                <div className="col-md-3 mb-3">
                    <div className="shadow bg-white rounded">
                        <img src={bmw} className="card-img-top w-100" alt="BMW" />
                        <div className="card-body">
                            <h5 className="card-title text-center">Card title</h5>
                        </div>
                    </div>
                </div>
                <div className="col-md-3 mb-3">
                    <div className="shadow bg-white rounded">
                        <img src={audi} className="card-img-top w-100" alt="Audi" />
                        <div className="card-body">
                            <h5 className="card-title text-center">Card title</h5>
                        </div>
                    </div>
                </div>
                <div className="col-md-3 mb-3">
                    <div className="shadow bg-white rounded">
                        <img src={audi} className="card-img-top w-100" alt="Audi" />
                        <div className="card-body">
                            <h5 className="card-title text-center">Card title</h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default PopularCars
