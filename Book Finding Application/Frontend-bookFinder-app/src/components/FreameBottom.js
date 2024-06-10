import React, { useState, useEffect } from 'react';
import axios from 'axios';

function CustomerDetails() {
   
    const [address, setAddress] = useState('');
    const [customers, setCustomers] = useState([]);
    const [bookName, setBookName] = useState('');
    const [customerList, setCustomerList] = useState([]);
  
   
  
    const handleAddressChange = (event) => {
      setAddress(event.target.value);
    };
  
    const handleBookNameChange = (event) => {
      setBookName(event.target.value);
    };
  

    const handleFetchCustomerList = () => {
      axios.get(`http://localhost:8080/product/${address}/${bookName}`)
        .then(response => {
          setCustomerList(response.data);
        })
        .catch(error => {
          console.error(error);
        });
    };

    return (
        <div style={{
          display: 'flex',
          flexDirection: 'row',
          justifyContent: 'space-between',
          alignItems: 'center',
          width: '80%',
          margin: '0 auto',
          padding: '20px'
        }}>
          
          <div style={{
            width: '40%',
            padding: '20px',
            border: '1px solid #ccc',
            borderRadius: '10px',
            boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)'
          }}>
            <h2 style={{ marginBottom: '20px' }}>Product Details</h2>
            <input
              type="text"
              value={address}
              onChange={handleAddressChange}
              placeholder="Enter Address"
              style={{
                padding: '10px',
                borderRadius: '20px',
                border: 'none',
                boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)',
                marginBottom: '10px'
              }}
            />
           
            <input
              type="text"
              value={bookName}
              onChange={handleBookNameChange}
              placeholder="Enter Book Name"
              style={{
                padding: '10px',
                borderRadius: '20px',
                border: 'none',
                boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)',
                marginBottom: '10px'
              }}
            />
            <button
              onClick={handleFetchCustomerList}
              style={{
                padding: '10px 20px',
                backgroundColor: '#4CAF50',
                color: 'white',
                border: 'none',
                borderRadius: '20px',
                cursor: 'pointer',
                marginBottom: '20px'
              }}
            >
              Fetch Customer List
            </button>
            {customerList.length > 0 && (
              <div style={{
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
                justifyContent: 'center',
                width: '200px',
                height: '300px',
                backgroundColor: '#f0f0f0',
                borderRadius: '50px',
                padding: '20px',
                marginBottom: '20px',
                boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)'
              }}>
                <h3 style={{ marginBottom: '10px' }}>Customer List:</h3>
                {customerList.map((customer, index) => (
                  <div
                    key={index}
                    style={{
                      backgroundColor: '#fff',
                      borderRadius: '10px',
                      padding: '10px',
                      marginBottom: '10px',
                      width: '300px',
                      boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)'
                    }}
                  >
                    <p style={{ fontWeight: 'bold', marginBottom: '5px' }}>Name: {customer.name}</p>
                    <p style={{ marginBottom: '5px' }}>PhoneNumber: {customer.number}</p>
                  </div>
                ))}
              </div>
            )}
          </div>
        </div>
      );
    
}
export default CustomerDetails;
