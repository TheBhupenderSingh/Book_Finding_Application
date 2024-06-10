import "./FrameComponent.css";

import React, { useState, useEffect } from 'react';
import axios from 'axios';

const FrameComponent = () => {

  const [customers, setCustomers] = useState([]);
  const [address, setAddress] = useState('');
  const [products, setProducts] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/customer')
      .then(response => {
        setCustomers(response.data);
      })
      .catch(error => {
        console.error(error);
      });
  }, []);

  const handleAddressChange = (event) => {
    setAddress(event.target.value);
  };

  const handleFetchProducts = () => {
    axios.get(`http://localhost:8080/product/${address}`)
      .then(response => {
        setProducts(response.data);
      })
      .catch(error => {
        console.error(error);
      });
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
        <h2 style={{ marginBottom: '20px' }}>All Customer Details</h2>
        {customers.map((customer, index) => (
          <div key={index} style={{
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
            <span style={{ marginBottom: '10px', fontWeight: 'bold' }}>{customer.name}</span>
            <span style={{ marginBottom: '10px' }}>{customer.number}</span>
            <span>{customer.address}</span>
          </div>
        ))}
      </div>
      <div style={{
        width: '40%',
        padding: '20px',
        border: '1px solid #ccc',
        borderRadius: '10px',
        boxShadow: '0 2px 4px rgba(0, 0, 0, 0.1)'
      }}>
        <h2 style={{ marginBottom: '20px' }}>Product Details according to input adderss</h2>
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
        <button
          onClick={handleFetchProducts}
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
          Fetch Products
        </button>
        {products.length > 0 && (
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
            <h3 style={{ marginBottom: '10px' }}>Products:</h3>
            {products.map((product, index) => (
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
                <p style={{ fontWeight: 'bold', marginBottom: '5px' }}>Book Name: {product.bookName}</p>
                <p style={{ marginBottom: '5px' }}>Author: {product.auther}</p>
              </div>
            ))}
          </div>


        )}
      </div>
    </div>
  );
  
};

export default FrameComponent;
