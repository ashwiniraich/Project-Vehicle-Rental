import React from 'react'
import bgimage5 from '../../images/bgimage5.jpg'

const Banner = () => {
  return (
    <div style={{ height: '90vh', overflow: 'hidden',marginBottom:50 }}>
            <img src={bgimage5} alt="BackGroundImage" style={{ width: '100%', height: '100%', objectFit: 'cover' }} />

        </div>
  )
}

export default Banner
