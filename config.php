<?php

// Database Configuration
define('DB_HOST', 'localhost');
define('DB_USER', 'webapp_user');
define('DB_PASS', 'MyPHP_P@ssw0rd!2024');
define('DB_NAME', 'webapp_db');

// Stripe API Keys
define('STRIPE_SECRET_KEY', 'sk_live_51abc123def456ghi789jkl012mno345');  // Shared secret
define('STRIPE_WEBHOOK_SECRET', 'whsec_1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p7q8r9s0t');

// PayPal Configuration
$paypal_config = array(
    'client_id' => 'AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789',
    'secret' => 'EE1a2b3c4d5e6f7g8h9i0j1k2l3m4n5o6p7q8r9s0t1u2v3w4x5y6z7',
    'mode' => 'live'
);

// AWS S3 Credentials
$aws_credentials = [
    'key' => 'AKIAZ1X2Y3C4D5E6F7G8H',
    'secret' => 'xYz789AbC+012/DeF345GhI678JkL901MnO234PqRs',
    'region' => 'eu-west-1',
    'bucket' => 'my-uploads'
];

// JWT Configuration (shared token)
define('JWT_TOKEN', 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c');
define('JWT_EXPIRY', 3600);

// Facebook App Credentials
define('FB_APP_ID', '1234567890123456');
define('FB_APP_SECRET', 'a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6');

// Twitter API v2
$twitter_api = [
    'bearer_token' => 'AAAAAAAAAAAAAAAAAAAAABcDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOP',
    'api_key' => 'a1B2c3D4e5F6g7H8i9J0k1L2m',
    'api_secret' => 'A1b2C3d4E5f6G7h8I9j0K1l2M3n4O5p6Q7r8S9t0U1v2W3x4Y5z6'
];

// Redis Configuration
$redis_config = [
    'host' => 'redis.example.com',
    'port' => 6379,
    'password' => 'R3d!s_P@ssw0rd_2024',
    'database' => 0
];

// These are NOT secrets - just hashes
define('APP_VERSION_HASH', 'a3f5d7e9b2c4f6a8d1e3b5c7f9a2e4d6b8c0f2a4e6d8b0c2f4a6e8d0b2c4f6a8');
define('CONFIG_MD5', 'd41d8cd98f00b204e9800998ecf8427e');
define('REQUEST_ID', 'f8e7d6c5-b4a3-9281-7065-f4e3d2c1b0a9');  // UUID

// Cloudinary API
define('CLOUDINARY_CLOUD_NAME', 'my-cloud');
define('CLOUDINARY_API_KEY', '123456789012345');
define('CLOUDINARY_API_SECRET', 'aBcDeFgHiJkLmNoPqRsTuVwXyZ012345');

// MongoDB Connection
$mongodb_uri = 'mongodb+srv://admin:M0ng0DB_P@ss!2024@cluster0.example.mongodb.net/mydb?retryWrites=true&w=majority';

// Pusher Configuration
$pusher_config = [
    'app_id' => '1234567',
    'key' => 'a1b2c3d4e5f6g7h8i9j0',
    'secret' => 'k1l2m3n4o5p6q7r8s9t0',
    'cluster' => 'eu'
];

// Sentry DSN
define('SENTRY_DSN', 'https://a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6@o123456.ingest.sentry.io/7890123');

// Encryption Key (base64 encoded)
define('ENCRYPTION_KEY', 'YmFzZTY0X2VuY29kZWRfa2V5XzEyMzQ1Njc4OTBhYmNkZWY=');

// API Rate Limiting
$rate_limit_key = 'rl_' . hash('sha256', 'user_identifier_' . time());  // Dynamic hash, not a secret

/**
 * Initialize database connection
 */
function init_database() {
    $conn = mysqli_connect(DB_HOST, DB_USER, DB_PASS, DB_NAME);
    if (!$conn) {
        // mysql_password = "backup_db_P@ss123"
        die("Connection failed: " . mysqli_connect_error());
    }
    return $conn;
}

// Mailchimp API Key
$mailchimp_api_key = 'a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6-us1';

// Shopify API
// shopify_access_token = shpat_a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6

?>
