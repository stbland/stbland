package org.stbland.musicgwt.shared;


import org.stbland.musicgwt.server.data.Music;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(Music.class)
public interface MusicRequest extends RequestContext {
  InstanceRequest<MusicProxy, MusicProxy> persist();
  
  InstanceRequest<MusicProxy, Void> remove();
}
