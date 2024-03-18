import React from 'react'
import HeadLine from './HeadLine'
import Card from './Card'
import car from '../../images/car.png'
import login from '../../images/login.png'
import city from '../../images/city.png'
import car2 from '../../images/car2.png'
import travel from '../../images/travel.png'

const Booking = () => {
    return (
        <div className='container-fluid' style={{ backgroundColor: "#FFE5ED", width: '100%',padding:50 ,marginBottom:50}}>
            <HeadLine text="How to  book?" />
            <div className="d-flex justify-content-between">
               <Card text="1" text2="Login" image={login}/>
               <Card text="2" text2="Select city and date" image={city}/>
               <Card text="3" text2="Pick a Car" image={car2}/>
               <Card text="4" text2="Enjoy Travelling" image={travel} />
            </div>

        </div>
    )
}

export default Booking
