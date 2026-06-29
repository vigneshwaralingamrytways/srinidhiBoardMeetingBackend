package com.SrinidhiBoardMeeting.Service;


import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SrinidhiBoardMeeting.Repo.RefreshTokenRepository;
import com.SrinidhiBoardMeeting.Repo.UserRepository;
import com.SrinidhiBoardMeeting.model.RefreshToken;
import com.SrinidhiBoardMeeting.model.Users;
 


@Service
public class RefreshTokenService {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;
    @Autowired
    private UserRepository userInfoRepository;
    
//    @Autowired
//    private ClientUserRepository clientUserRepository;

//    public RefreshToken createRefreshToken(String username) {
//        RefreshToken refreshToken = RefreshToken.builder()
//                .userInfo(userInfoRepository.findByUserName(username).get())
//                .token(UUID.randomUUID().toString())
//              //  .expiryDate(Instant.now().plusMillis(600000))
//                .expiryDate(Instant.now().plusMillis(1*60*1000))
//                .build();
//        return refreshTokenRepository.save(refreshToken);
//    }
    
    public RefreshToken createRefreshToken(String username) {
   	 Optional<Users> user = userInfoRepository.findByUserName(username);
        if (user.isPresent()) {
            return createForUser(user.get());
        }
//        else {
//        	Optional<ClientUsers> client = clientUserRepository.findByUserName(username);
//        	if(client.isPresent()) {
//        		ClientUsers clientUser=client.get();
//            if (clientUser != null) {
//                return createForClient(clientUser);
//            } else {
//                throw new RuntimeException("User or Client not found with username: " + username);
//            }
//         }
        	else {
                throw new RuntimeException("User or Client not found with username: " + username);
            }
//    }
        
    }

        private RefreshToken createForUser(Users user) {
       	 RefreshToken refreshToken = RefreshToken.builder()
                   .userInfo(user)
                   .token(UUID.randomUUID().toString())
                   .expiryDate(Instant.now().plusMillis(1 * 60 * 1000))
                   .build();
           return refreshTokenRepository.save(refreshToken);
       }

//       private RefreshToken createForClient(ClientUsers clientUsers) {
//       	 RefreshToken refreshToken = RefreshToken.builder()
//                   .clientInfo(clientUsers)
//                   .token(UUID.randomUUID().toString())
//                   .expiryDate(Instant.now().plusMillis(1 * 60 * 1000))
//                   .build();
//       	 return refreshTokenRepository.save(refreshToken);
//       }
       
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }


    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + " Refresh token was expired. Please make a new signin request");
        }
        return token;
    }
    
    
   
}