import React from 'react'
import { Link } from 'react-router-dom'

const Register = () => {
    return (
        <div>
            <div className="container mt-5">
                <div className="row justify-content-center">
                    <div className="col-md-6">
                        <div className="card">
                            <div className="card-header">
                                <h3 className="text-center">Register</h3>
                            </div>
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label for="username">Username:</label>
                                        <input type="text" className="form-control" id="username" placeholder="Enter your username"/>
                                    </div>
                                    <div className="form-group">
                                        <label for="email">Email:</label>
                                        <input type="email" className="form-control" id="email" placeholder="Enter your email"/>
                                    </div>
                                    <div className="form-group">
                                        <label for="password">Password:</label>
                                        <input type="password" className="form-control" id="password" placeholder="Enter your password"/>
                                    </div>
                                    <div className="form-group">
                                        <label for="confirmPassword">Confirm Password:</label>
                                        <input type="password" className="form-control" id="confirmPassword" placeholder="Confirm your password"/>
                                    </div>
                                    <button type="submit" className="btn btn-primary btn-block">Register</button>
                                </form>
                            </div>
                            <div className="card-footer">
                                <p className="text-center mb-0">Already have an account? <Link to='/login'>Login</Link></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Register
