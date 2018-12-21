package com.litetech.tuby.utils;

public class AuthHelper {
//    private FirebaseAuth auth = FirebaseAuth.getInstance();
//    private AppCompatActivity activity;
//    private static final int RC_SIGN_IN = 9001;
//    private static final String TAG = "LogIn Activity";
//    private FirebaseFirestore db = FirebaseFirestore.getInstance();
//    private ProgressDialog dialog;
//    private CallbackManager callbackManager;
//    private Context context;
//    private User userBackUp;
//    private UICreator creator;
//    private boolean fromProvider = false;
//    private String provider = "";
//
//    public static AuthHelper getInstance(Activity activity) {
//        return new AuthHelper(activity);
//    }
//
//
//    private AuthHelper(Activity activity) {
//        this.activity = (AppCompatActivity) activity;
//        this.dialog = new ProgressDialog(this.activity);
//        this.context = activity.getApplicationContext();
//        creator = UICreator.getInstance((AppCompatActivity) activity);
//    }
//
//
//    public void signUp(final String name, final String email, final String password) {
//        showDialog("Please wait...", false);
//        auth.createUserWithEmailAndPassword(email, password)
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        FirebaseUser user = auth.getCurrentUser();
//                        if (user != null) {
//                            UserProfileChangeRequest userProfileChangeRequest = new UserProfileChangeRequest.Builder()
//                                    .setDisplayName(name)
//                                    .setPhotoUri(Uri.parse("https://firebasestorage.googleapis.com/v0/b/riviwsapp.appspot.com/o/otherimages%2Fuser-2.png?alt=media&token=f3265050-1601-402d-9018-b2b1a1e31415"))
//                                    .build();
//                            user.updateProfile(userProfileChangeRequest);
//                            User editedUser = new User(user);
//                            editedUser.setUserName(name);
//                            editedUser.setProfilePhotoUrl("https://firebasestorage.googleapis.com/v0/b/riviwsapp.appspot.com/o/otherimages%2Fuser-2.png?alt=media&token=f3265050-1601-402d-9018-b2b1a1e31415");
//                            editedUser.setVerified(false);
//                            updateUser(editedUser);
//                        }
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                dialog.dismiss();
//                creator.ShowAlert("Authentication Failed",e.getMessage());
//            }
//        });
//    }
//
//
//    public void googleSignIn() {
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(activity.getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build();
//        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(context, gso);
//        Intent googleSignInIntent = googleSignInClient.getSignInIntent();
//        activity.startActivityForResult(googleSignInIntent, RC_SIGN_IN);
//        activity.setResult(RC_SIGN_IN);
//    }
//
//
//    public void facebookSignIn(LoginButton fbBtn) {
//
//        callbackManager = CallbackManager.Factory.create();
//
//        fbBtn.performClick();
//
//        fbBtn.setReadPermissions("email", "public_profile");
//
//        fbBtn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(final LoginResult loginResult) {
//
//
//                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
//                    @Override
//                    public void onCompleted(JSONObject object, GraphResponse response) {
//                        try {
//                            facebookSignIn(loginResult.getAccessToken().getToken(), object.getString("email"));
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//
//                Bundle parameters = new Bundle();
//                parameters.putString("fields", "name,email");
//                request.setParameters(parameters);
//                request.executeAsync();
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(FacebookException error) {
////                showDialog(error.getMessage(), true);
//                creator.ShowAlert("Log In Failed","Please ensure your device is connected to the internet");
//            }
//        });
//    }
//
//
//    public void firebaseAuthWithGoogle(GoogleSignInAccount account) {
//
//        AuthCredential authCredential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
//        firebaseSignCredential(authCredential, account.getEmail(),"google",true);
//    }
//
//
//    public void signInWithEmailAndPassword(String email, String password) {
//
//        AuthCredential credential = EmailAuthProvider.getCredential(email, password);
//        firebaseSignCredential(credential, email,"email",false);
//    }
//
////    private void facebookSignIn(String fbToken, String email) {
////
////        AuthCredential credential = FacebookAuthProvider.getCredential(fbToken);
////        firebaseSignCredential(credential, email,"facebook",true);
////
////    }
//
//
//    private void firebaseSignCredential(AuthCredential authCredential, final String email, final String provider, final boolean fromProvider) {
//        showDialog("Please wait...", false);
//        auth.signInWithCredential(authCredential)
//                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//
//                            User user = new User(Objects.requireNonNull(auth.getCurrentUser()));
//                            user.setEmail(email);
//                            if (fromProvider){
//                                user.setVerified(true);
//                            }
//                            user.setProvider(provider);
//                            updateUser(user);
//                        } else {
//                            dismissDialog();
//                            Snackbar.make(activity.getWindow().getDecorView().getRootView(), "Authentication Failed.", Snackbar.LENGTH_LONG).show();
//                        }
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                dialog.dismiss();
//                creator.ShowAlert("Authentication Failed",e.getMessage());
//            }
//        });
//    }
//
//    private void showDialog(String s, boolean b) {
//        dialog.setMessage(s);
//        dialog.setCancelable(b);
//        dialog.show();
//    }
//
//    @SuppressWarnings("all")
//    private void saveUserInfo(User user) {
//        db.collection("users").document(user.getUid()).set(new ObjectMapper().convertValue(user, Map.class))
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        success();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.w(TAG, "Error adding document", e);
//            }
//        });
//    }
//
//
//    @SuppressWarnings("all")
//    private void updateUser(User user) {
//        if (user.getUserName() == null) {
//            userBackUp = new User(FirebaseAuth.getInstance().getCurrentUser());
//        } else {
//            userBackUp = user;
//        }
//        DocumentReference userDoc = db.collection("users").document(user.getUid());
//
//        userDoc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                if (!documentSnapshot.exists()) {
//                    saveUserInfo(userBackUp);
//                } else {
//                    success();
//                }
//            }
//        });
//    }
//
//
//    private void success() {
//        if (activity != null) {
//            dismissDialog();
//            activity.startActivity(new Intent(activity, BaseHome.class));
//        }
//    }
//
//    private void dismissDialog() {
////        if (activity.isDestroyed()){
//////            if (dialog != null && dialog.isShowing()) {
//////                dialog.dismiss();
//////            }
////        }
//    }
//
//
//    public CallbackManager getCallbackManager() {
//        return callbackManager;
//    }
//
//
//    public static int getRcSignIn() {
//        return RC_SIGN_IN;
//    }
//
//
//    public void setContext(Context context) {
//        this.context = context;
//    }
}
