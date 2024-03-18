import React from 'react'
import { Link } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import { useState } from 'react';
import Home from '../home/Home';
import Login from '../pages/Login';

const Navbar = () => {
    const [IsLogin, setIsLogin] = useState(false);
    //const [isHome, setIsHome] = useState(false);


    const navigate = useNavigate();

    
    const loginpage = () => {
        setIsLogin(true);
    };
    return (
        <div>

            <nav className="navbar navbar-expand-lg navbar-light bg-light fixed-top border-bottom navBar">
                <Link to='/' class="navbar-brand">BrandName</Link>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>

                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav mr-auto">
                        {/* <li className="nav-item active">
                            <button type='button' className='nav-link noBorder' onClick={homepage}>Home</button>
                        </li>
                        <li className="nav-item">
                        <button type='button' className='nav-link noBorder' onClick={homepage}>Home</button>
                        </li> */}

                    </ul>
                    <form className="d-flex mx-auto">
                        <input className="form-control me-2" type="search" placeholder="Location..." aria-label="Search" />
                        <button className="btn btn-outline-success" type="submit" >Search</button>
                    </form>
                    <div>
                    <button type='button' className="btn btn-light">
                            {IsLogin ? null : <Link to='/login'>Login/Register</Link>}
                        </button>
                    </div>
                </div>
            </nav>
        </div>
    )
}

export default Navbar
