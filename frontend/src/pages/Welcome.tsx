import { Link, useLocation } from 'react-router-dom';

export default function Welcome() {
  const location = useLocation();
  const username = location.state?.username || 'User';

  return (
    <div className="app-container">
      <div className="glass-panel welcome-content">
        <h2>Welcome to the Lounge!</h2>
        <p>
          Hello, <strong>{username}</strong>! You have successfully logged into your account.
          Enjoy the premium experience.
        </p>
        
        <Link to="/login" className="btn-secondary">
          Logout
        </Link>
      </div>
    </div>
  );
}
