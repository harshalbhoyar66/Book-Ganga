import React from 'react';
import Admin from '../images/admin.png';
import Admin2 from '../images/admin2.jpeg';

let AdminComponent = () => {
    return (
        <div style={{ "marginTop": "50px", "color": "black", "textAlign": "center", "padding": "20px", "backgroundColor": "#f9f9f9", "borderRadius": "10px", "boxShadow": "0px 4px 12px rgba(0, 0, 0, 0.1)" }}>
            <h3 style={{ "fontSize": "2.5em", "fontWeight": "bold", "color": "#444" }}>Admin Dashboard</h3>

            <div style={{ "marginTop": "20px" }}>
                <img src={Admin} alt="Admin Welcome" style={{ "borderRadius": "10px", "marginBottom": "20px", "boxShadow": "0px 4px 8px rgba(0, 0, 0, 0.1)" }} />
                
                <h1 style={{ "color": "#4CAF50", "marginTop": "20px" }}>Welcome, Admin!</h1>
                
                <p style={{ "fontSize": "1.2em", "color": "#666", "maxWidth": "600px", "margin": "0 auto" }}>
                    Thank you for your dedication and hard work in managing the platform. Your role is vital in ensuring that everything runs smoothly, and we appreciate all the effort you put in behind the scenes.
                </p>

                <p style={{ "fontSize": "1.1em", "color": "#888", "maxWidth": "600px", "margin": "20px auto" }}>
                    Feel free to explore and monitor the system. If you ever need assistance, remember that the team is always here to support you.
                </p>
            </div>

            <div style={{ "marginTop": "30px" }}>
                <img src={Admin2} alt="Admin Illustration" style={{ "borderRadius": "10px", "boxShadow": "0px 4px 8px rgba(0, 0, 0, 0.1)" }} />
            </div>

            <div style={{ "marginTop": "50px" }}>
                <h2 style={{ "color": "#3b5998" }}>Stay Updated</h2>
                <p style={{ "fontSize": "1.1em", "color": "#555", "maxWidth": "600px", "margin": "0 auto" }}>
                    Keep an eye on the latest updates and ensure the system is always up to date. Thank you for your valuable contribution to keeping things in order!
                </p>
            </div>
        </div>
    )
}

export default AdminComponent;
