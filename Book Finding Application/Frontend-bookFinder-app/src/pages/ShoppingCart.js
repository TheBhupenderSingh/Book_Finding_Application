import MyProfile from "../components/MyProfile";
import PageHeading from "../components/PageHeading";
import FrameComponent from "../components/FrameComponent";
import "./ShoppingCart.css";
import FreameBottom from "../components/FreameBottom"

const ShoppingCart = () => {
  return (
    <div className="shopping-cart">
      <header className="shopping-cart-inner">
        <nav className="frame-parent">
          <div className="bookish-wrapper">
            <h2 className="bookish">Bookish</h2>
          </div>
          <input className="frame-child" placeholder="Search" type="text" />
          <div className="my-profile-notification-wrapper">
            <div className="my-profile-notification">
              <div className="notifications">Notifications</div>
              <MyProfile myProfile="My Profile" />
            </div>
          </div>
        </nav>
      </header>
      <PageHeading />
      <FrameComponent />
      <FreameBottom />
      

    </div>
  );
};

export default ShoppingCart;
