import React from 'react'
import bgimage3 from '../../images/bgimage3.jpg'
import Navbar from '../Navbar/Navbar'
import Banner from './Banner'
import { useState } from 'react'
import Login from '../pages/Login'
import PopularCars from './PopularCars'
import ExploreCars from './ExploreCars'
import Booking from './Booking'
import FooterCaption from '../footer/FooterCaption'
import Footer from '../footer/Footer'


const Home = () => {
    const [IsLogin, setIsLogin] = useState(false);
    return (
        <div >
         <Banner/>
         <PopularCars/>
         <Booking/>
         <ExploreCars/>
         <Footer />
        </div>
    )
}

export default Home
